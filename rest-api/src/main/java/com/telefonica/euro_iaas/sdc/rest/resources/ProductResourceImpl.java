package com.telefonica.euro_iaas.sdc.rest.resources;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Path;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sun.jersey.api.core.InjectParam;
import com.sun.jersey.multipart.BodyPartEntity;
import com.sun.jersey.multipart.MultiPart;
import com.telefonica.euro_iaas.commons.dao.EntityNotFoundException;
import com.telefonica.euro_iaas.sdc.exception.AlreadyExistsProductReleaseException;
import com.telefonica.euro_iaas.sdc.exception.InvalidMultiPartRequestException;
import com.telefonica.euro_iaas.sdc.exception.InvalidProductReleaseException;
import com.telefonica.euro_iaas.sdc.exception.InvalidProductReleaseUpdateRequestException;
import com.telefonica.euro_iaas.sdc.exception.ProductReleaseNotFoundException;
import com.telefonica.euro_iaas.sdc.exception.ProductReleaseStillInstalledException;
import com.telefonica.euro_iaas.sdc.exception.SdcRuntimeException;
import com.telefonica.euro_iaas.sdc.manager.ProductManager;
import com.telefonica.euro_iaas.sdc.model.Attribute;
import com.telefonica.euro_iaas.sdc.model.Product;
import com.telefonica.euro_iaas.sdc.model.ProductRelease;
import com.telefonica.euro_iaas.sdc.model.dto.ProductReleaseDto;
import com.telefonica.euro_iaas.sdc.model.dto.ReleaseDto;
import com.telefonica.euro_iaas.sdc.model.searchcriteria.ProductReleaseSearchCriteria;
import com.telefonica.euro_iaas.sdc.model.searchcriteria.ProductSearchCriteria;
import com.telefonica.euro_iaas.sdc.rest.validation.ProductResourceValidator;

/**
 * default ProductResource implementation
 *
 * @author Sergio Arroyo
 *
 */
@Path("/catalog/product")
@Component
@Scope("request")
public class ProductResourceImpl implements ProductResource {

    @InjectParam("productManager")
    private ProductManager productManager;
    
    private ProductResourceValidator validator;
    private static Logger LOGGER = Logger.getLogger("ProductResourceImpl");
    
    /**
     * {@inheritDoc}
     * @throws InvalidProductReleaseUpdateRequestException 
     * @throws InvalidMultiPartRequestException 
     */
    @Override
    public ProductRelease insert(MultiPart multiPart)
    	throws AlreadyExistsProductReleaseException, 
    	InvalidProductReleaseException, 
    	InvalidMultiPartRequestException {
    	
    	validator.validateInsert(multiPart);
    	
    	File cookbook = null;
    	File installable = null;
    	
    	// First part contains a Project object
    	ProductReleaseDto productReleaseDto =
			(ProductReleaseDto)multiPart.getBodyParts().get(0).getEntity();
        
    	Product product = new Product (
				productReleaseDto.getProductName(),
				productReleaseDto.getProductDescription());
    	
    	for (int i=0; productReleaseDto.getPrivateAttributes().size() < 1; i++)
    		product.addAttribute(productReleaseDto.getPrivateAttributes().get(i));
		
		ProductRelease productRelease = new ProductRelease(
                productReleaseDto.getVersion(), 
                productReleaseDto.getReleaseNotes(),
                productReleaseDto.getPrivateAttributes(),
                product,
                productReleaseDto.getSupportedOS(),
                productReleaseDto.getTransitableReleases() );
		
		
		try{
			cookbook = File.createTempFile("cookbook-" + 
					productReleaseDto.getProductName() + "-" +
					productReleaseDto.getVersion() + ".tar", ".tmp");  
			
	    	installable = File.createTempFile("installable-" + 
					productReleaseDto.getProductName() + "-" +
					productReleaseDto.getVersion() + ".tar", ".tmp");
	    	
	        cookbook = 
	        	getFileFromBodyPartEntity ((BodyPartEntity) multiPart.getBodyParts().get(1).getEntity(), cookbook);
	        installable = 
	        	getFileFromBodyPartEntity ((BodyPartEntity) multiPart.getBodyParts().get(2).getEntity() ,installable);
	       
		} catch (IOException e){
			throw new RuntimeException(e);	
		}
		
        return productManager.insert(productRelease, cookbook, 
				installable);
    }
    
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Product> findAll(Integer page, Integer pageSize,
            String orderBy, String orderType) {
        ProductSearchCriteria criteria = new ProductSearchCriteria();

        if (page != null && pageSize != null) {
            criteria.setPage(page);
            criteria.setPageSize(pageSize);
        }
        if (!StringUtils.isEmpty(orderBy)) {
            criteria.setOrderBy(orderBy);
        }
        if (!StringUtils.isEmpty(orderType)) {
            criteria.setOrderBy(orderType);
        }
        return productManager.findByCriteria(criteria);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Product load(String name) throws EntityNotFoundException {
        return productManager.load(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Attribute> loadAttributes(String name)
            throws EntityNotFoundException {
        return productManager.load(name).getAttributes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ProductRelease> findAll(String name, Integer page,
            Integer pageSize, String orderBy, String orderType) {
        ProductReleaseSearchCriteria criteria = new ProductReleaseSearchCriteria();

        if (!StringUtils.isEmpty(name)) {
            try {
                Product product = productManager.load(name);
                criteria.setProduct(product);
            } catch (EntityNotFoundException e) {
                throw new SdcRuntimeException("Can not find the application "
                        + name, e);
            }
        }

        if (page != null && pageSize != null) {
            criteria.setPage(page);
            criteria.setPageSize(pageSize);
        }
        if (!StringUtils.isEmpty(orderBy)) {
            criteria.setOrderBy(orderBy);
        }
        if (!StringUtils.isEmpty(orderType)) {
            criteria.setOrderBy(orderType);
        }
        return productManager.findReleasesByCriteria(criteria);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductRelease load(String name, String version)
            throws EntityNotFoundException {
        Product product = productManager.load(name);
        return productManager.load(product, version);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(String name, String version) 
    throws ProductReleaseNotFoundException, ProductReleaseStillInstalledException{
    	
    	LOGGER.log(Level.INFO,"Delete ProductRelease. ProductName : " 
    			+ name
    			+ " ProductVersion : " + version);
    	
    	Product product = new Product();
    	product.setName(name);
    	
    	ProductRelease productRelease = new ProductRelease();
       	productRelease.setVersion(version);
       	productRelease.setProduct(product);
       	
       	try {
			productManager.load(product, version);
		} catch (EntityNotFoundException e) {
			throw new ProductReleaseNotFoundException(e);
		}
    	
		productManager.delete(productRelease);
    }
    
    public ProductRelease update(String name, String version, MultiPart multiPart) 
        throws ProductReleaseNotFoundException, 
        InvalidProductReleaseException, 
        InvalidProductReleaseUpdateRequestException,
        InvalidMultiPartRequestException {
    	
    	ReleaseDto releaseDto = new ReleaseDto(name, version, "product");
    	validator.validateUpdate(releaseDto, multiPart);
    	
    	File cookbook = null;
       	File installable = null;
       	ProductReleaseDto productReleaseDto = new ProductReleaseDto();
       	ProductRelease productRelease = new ProductRelease();
       	Product product = new Product ();
       	
       	productReleaseDto =
			(ProductReleaseDto)multiPart.getBodyParts().get(0).getEntity(); 
       		
       	
       	product.setName(productReleaseDto.getProductName());
       	product.setDescription(productReleaseDto.getProductDescription());
        	
       	for (int i=0; productReleaseDto.getPrivateAttributes().size() < i; i++)
       		product.addAttribute(productReleaseDto.getPrivateAttributes().get(i));
    		
       	productRelease.setVersion(productReleaseDto.getVersion());
       	productRelease.setReleaseNotes(productReleaseDto.getReleaseNotes());
       	productRelease
       		.setPrivateAttributes(productReleaseDto.getPrivateAttributes());
       	productRelease.setSupportedOOSS(productReleaseDto.getSupportedOS());
       	productRelease
       		.setTransitableReleases(productReleaseDto.getTransitableReleases()); 
       	
       try{
    	   cookbook = File.createTempFile("cookbook-" + 
        		releaseDto.getName() + "-" +
        		releaseDto.getVersion() + ".tar", ".tmp");  
    	   cookbook = 
          	  	getFileFromBodyPartEntity ((BodyPartEntity) multiPart.getBodyParts().get(1).getEntity(), cookbook); 
       	} catch (IOException e){
        	throw new SdcRuntimeException(e);	
        }
       	
       	try{
       		installable = File.createTempFile("installable-" + 
       			releaseDto.getName() + "-" +
       			releaseDto.getVersion() + ".tar", ".tmp");  
       		installable = 
              	getFileFromBodyPartEntity (
           			(BodyPartEntity) multiPart.getBodyParts().get(2).getEntity() 
           			,installable);
       	} catch (IOException e){
        	throw new SdcRuntimeException(e);	
        }
       	
       	try {
			productManager.load(product, version);
		} catch (EntityNotFoundException e) {
			throw new ProductReleaseNotFoundException(e);
		}
		
       	return productManager.update(productRelease, 
       			cookbook,installable); 	
    }
    
    private File getFileFromBodyPartEntity(BodyPartEntity bpe, File file )
    {
        try {
        	InputStream input = bpe.getInputStream();
        	
        	OutputStream out=new FileOutputStream(file);
          
        	byte[] buf =new byte[1024];
        	int len;
        	while((len=input.read(buf))>0){
        		out.write(buf,0,len);
        	}
        	out.close();
        	input.close();
                  
        }catch(IOException e){
        	System.out.println("An error was produced : "+e.toString());
        }
        return file;
        
    }
    
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Attribute> loadAttributes(String name, String version)
            throws EntityNotFoundException {
        return load(name, version).getAttributes();
    }

    @Override
    public List<ProductRelease> findTransitable(String name, String version)
            throws EntityNotFoundException {
        return load(name, version).getTransitableReleases();
    }
    
    /**
     * @param validator the validator to set
     */
    public void setValidator(ProductResourceValidator validator) {
        this.validator = validator;
    }

}
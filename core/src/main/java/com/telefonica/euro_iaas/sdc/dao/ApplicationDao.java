/**
 *   (c) Copyright 2013 Telefonica, I+D. Printed in Spain (Europe). All Rights
 *   Reserved.
 * 
 *   The copyright to the software program(s) is property of Telefonica I+D.
 *   The program(s) may be used and or copied only with the express written
 *   consent of Telefonica I+D or in accordance with the terms and conditions
 *   stipulated in the agreement/contract under which the program(s) have
 *   been supplied.
 */

package com.telefonica.euro_iaas.sdc.dao;

import java.util.List;

import com.telefonica.euro_iaas.commons.dao.BaseDAO;
import com.telefonica.euro_iaas.sdc.model.Application;
import com.telefonica.euro_iaas.sdc.model.searchcriteria.ApplicationSearchCriteria;

/**
 * Defines the methods needed to persist Application objects.
 * 
 * @author Sergio Arroyo.
 */
public interface ApplicationDao extends BaseDAO<Application, String> {
    /**
     * Find by criteria
     * 
     * @param criteria
     *            the search criteria (containing pagination info, and some fields criteria).
     * @return the elements that match with the search criteria
     */
    List<Application> findByCriteria(ApplicationSearchCriteria criteria);

}

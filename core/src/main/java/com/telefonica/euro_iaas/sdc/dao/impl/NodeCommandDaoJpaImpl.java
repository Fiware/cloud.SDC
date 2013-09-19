package com.telefonica.euro_iaas.sdc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.telefonica.euro_iaas.commons.dao.AbstractBaseDao;
import com.telefonica.euro_iaas.commons.dao.EntityNotFoundException;
import com.telefonica.euro_iaas.sdc.dao.NodeCommandDao;
import com.telefonica.euro_iaas.sdc.model.OS;
import com.telefonica.euro_iaas.sdc.model.NodeCommand;
import com.telefonica.euro_iaas.sdc.model.searchcriteria.NodeCommandSearchCriteria;

/**
 * JPA based  implementation for NodeCommandDao.
 *
 * @author Jesus M. Movilla
 *
 */
public class NodeCommandDaoJpaImpl
    extends AbstractBaseDao<NodeCommand, Long>
    implements NodeCommandDao {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<NodeCommand> findAll() {
        return super.findAll(NodeCommand.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NodeCommand load(Long arg0) throws EntityNotFoundException {
        return super.loadByField(NodeCommand.class, "id", arg0);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<NodeCommand> findByCriteria(
            NodeCommandSearchCriteria criteria) {
        Session session = (Session) getEntityManager().getDelegate();
        Criteria baseCriteria = session.createCriteria(
                NodeCommand.class);
        if (criteria.getOS() != null) {
            baseCriteria.add(Restrictions.eq(
                    "os", criteria.getOS()));
        }
        
        List<NodeCommand> nodeCommands = setOptionalPagination(criteria, 
        		baseCriteria).list();
        
        if (criteria.getOS() != null) {
        	nodeCommands = filterByOS(nodeCommands, criteria.getOS());
        }
        return nodeCommands;

    }

        
    /**
     * Filter the result by os
     *
     * @param nodeCommands
     * @param os
     * @return
     */
    private List<NodeCommand> filterByOS(
            List<NodeCommand> nodeCommands, OS os) {
        List<NodeCommand> result = new ArrayList<NodeCommand>();
        for (NodeCommand nodeCommand : nodeCommands) {
            	if (nodeCommand.getOS().getOsType().equals(os.getOsType())) {
                    result.add(nodeCommand);
                }
        }
        return result;
    }

}

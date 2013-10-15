/**
 * (c) Copyright 2013 Telefonica, I+D. Printed in Spain (Europe). All Rights Reserved.<br>
 * The copyright to the software program(s) is property of Telefonica I+D. The program(s) may be used and or copied only
 * with the express written consent of Telefonica I+D or in accordance with the terms and conditions stipulated in the
 * agreement/contract under which the program(s) have been supplied.
 */

package com.telefonica.euro_iaas.sdc.model.dto;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

/**
 * Models a chef node.
 * 
 * @author Sergio Arroyo
 */
public class ChefNode {

    private final static String RECIPE_ITEM_TEMPLATE = "recipe[{0}]";

    private String name;
    private Map<String, Object> attributes;
    private Map<String, Object> overrides;
    private Map<String, Object> defaults;
    private List<String> runlList;
    private String chefType = "node";
    private String jsonClass = "Chef::Node";

    /**
     *
     */
    public ChefNode() {
        attributes = new HashMap<String, Object>();
        overrides = new HashMap<String, Object>();
        defaults = new HashMap<String, Object>();
        runlList = new ArrayList<String>();
    }

    public void addRecipe(String recipe) {
        String formatedRecipe = MessageFormat.format(RECIPE_ITEM_TEMPLATE, recipe);
        if (!runlList.contains(formatedRecipe)) {
            runlList.add(MessageFormat.format(RECIPE_ITEM_TEMPLATE, recipe));
        }
    }

    public void removeRecipe(String recipe) {
        runlList.remove(MessageFormat.format(RECIPE_ITEM_TEMPLATE, recipe));
    }

    public void addOverride(String key, String value) {
        overrides.put(key, value);
    }

    public void addOverride(String process, String key, String value) {
        overrides = addNewAttribute(overrides, process, key, value);
    }

    public void addDefault(String process, String key, String value) {
        defaults = addNewAttribute(defaults, process, key, value);
    }

    public void addAttribute(String process, String key, String value) {
        attributes = addNewAttribute(attributes, process, key, value);
    }

    private Map<String, Object> addNewAttribute(Map<String, Object> map, String process, String key, String value) {
        JSONObject attr;
        if (map.containsKey(process)) {
            attr = (JSONObject) map.get(process);
        } else {
            attr = new JSONObject();
        }
        attr.put(key, value);
        map.put(process, attr);
        return map;
    }

    public void removeOverride(String key) {
        overrides.remove(key);
    }

    public void addDefault(String key, String value) {
        defaults.put(key, value);
    }

    public void removeDefault(String key) {
        defaults.remove(key);
    }

    public void addAttritube(String key, String value) {
        attributes.put(key, value);
    }

    public void removeAttritube(String key) {
        attributes.remove(key);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the attributes
     */
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    /**
     * @param attributes
     *            the attributes to set
     */
    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    /**
     * @return the overrides
     */
    public Map<String, Object> getOverrides() {
        return overrides;
    }

    /**
     * @param overrides
     *            the overrides to set
     */
    public void setOverrides(Map<String, Object> overrides) {
        this.overrides = overrides;
    }

    /**
     * @return the defaults
     */
    public Map<String, Object> getDefaults() {
        return defaults;
    }

    /**
     * @param defaults
     *            the defaults to set
     */
    public void setDefaults(Map<String, Object> defaults) {
        this.defaults = defaults;
    }

    /**
     * @return the runlList
     */
    public List<String> getRunlList() {
        return runlList;
    }

    /**
     * @param runlList
     *            the runlList to set
     */
    public void setRunlList(List<String> runlList) {
        this.runlList = runlList;
    }

    /**
     * @return the chefType
     */
    public String getChefType() {
        return chefType;
    }

    /**
     * @param chefType
     *            the chefType to set
     */
    public void setChefType(String chefType) {
        this.chefType = chefType;
    }

    /**
     * @return the jsonClass
     */
    public String getJsonClass() {
        return jsonClass;
    }

    /**
     * @param jsonClass
     *            the jsonClass to set
     */
    public void setJsonClass(String jsonClass) {
        this.jsonClass = jsonClass;
    }

    /**
     * JSon serializer
     */
    public String toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.accumulate("name", name);
        jsonObject.accumulate("json_class", "Chef::Node");
        jsonObject.accumulate("normal", attributes);
        jsonObject.accumulate("default", defaults);
        jsonObject.accumulate("override", overrides);
        jsonObject.accumulate("run_list", runlList);
        return jsonObject.toString();
    }

    @SuppressWarnings("unchecked")
    public void fromJson(JSONObject jsonNode) {
        name = jsonNode.getString("name");
        runlList = jsonNode.getJSONArray("run_list");
        overrides = jsonNode.getJSONObject("override");
        defaults = jsonNode.getJSONObject("default");
        attributes = jsonNode.getJSONObject("normal");
    }

}

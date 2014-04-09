# -*- coding: utf-8 -*-

### constants
OPERATION = u'operation'
CODE      = u'code'
BODY      = u'body'
LABEL     = u'label'
VALUE     = u'value'
CONTENT   = u'content'
POSITION  = u'position'

#responses

Catalog_body = [
    ####  Products   ####
    {OPERATION: "Products list JSON",            		    CODE: "OK",               BODY: '{"name":"","description":"Product only for test","attributes":[{"key":"username","value":"postgres","description":"The administrator username"},{"key":"password","value":"postgres","description":"The administrator password"}],"metadatas":[{"key":"image","value":"e6c5b19e-f655-4da8-86ea-6dd05be673ef"},{"key":"cookbook_url","value":"https://forge.fi-ware.eu/scmrepos/svn/testbed/trunk/cookbooks/GESoftware/beatest"},{"key":"cloud","value":"yes"},{"key":"installator","value":"chef"},{"key":"open_ports","value":"22"},{"key":"repository","value":"svn"},{"key":"public","value":"no"},{"key":"dependencies","value":"tomcat nodejs mysql"}]}'},
    {OPERATION: "Products list XML",           		        CODE: "OK",               BODY: '<product><name></name><description>Product only for test</description><attributes><key>username</key><value>postgres</value><description>The administrator username</description></attributes><attributes><key>password</key><value>postgres</value><description>The administrator password</description></attributes><metadatas><key>image</key><value>e6c5b19e-f655-4da8-86ea-6dd05be673ef</value></metadatas><metadatas><key>cookbook_url</key><value>https://forge.fi-ware.eu/scmrepos/svn/testbed/trunk/cookbooks/GESoftware/beatest</value></metadatas><metadatas><key>cloud</key><value>yes</value></metadatas><metadatas><key>installator</key><value>chef</value></metadatas><metadatas><key>open_ports</key><value>22</value></metadatas><metadatas><key>repository</key><value>svn</value></metadatas><metadatas><key>public</key><value>no</value></metadatas><metadatas><key>dependencies</key><value>tomcat nodejs mysql</value></metadatas></product>'},
    {OPERATION: "Product details JSON",              	    CODE: "OK",               BODY: '{"name":"Product_test_0001","description":"Product only for test","attributes":[{"key":"username","value":"postgres","description":"The administrator username"},{"key":"password","value":"postgres","description":"The administrator password"}],"metadatas":[{"key":"image","value":"e6c5b19e-f655-4da8-86ea-6dd05be673ef"},{"key":"cookbook_url","value":"https://forge.fi-ware.eu/scmrepos/svn/testbed/trunk/cookbooks/GESoftware/beatest"},{"key":"cloud","value":"yes"},{"key":"installator","value":"chef"},{"key":"open_ports","value":"22"},{"key":"repository","value":"svn"},{"key":"public","value":"no"},{"key":"dependencies","value":"tomcat nodejs mysql"}]}'},
    {OPERATION: "Product details XML",              	    CODE: "OK",               BODY: '<?xml version="1.0" encoding="UTF-8" standalone="yes"?><product><name>Product_test_0001</name><description>Product only for test</description><attributes><key>username</key><value>postgres</value><description>The administrator username</description></attributes><attributes><key>password</key><value>postgres</value><description>The administrator password</description></attributes><metadatas><key>image</key><value>e6c5b19e-f655-4da8-86ea-6dd05be673ef</value></metadatas><metadatas><key>cookbook_url</key><value>https://forge.fi-ware.eu/scmrepos/svn/testbed/trunk/cookbooks/GESoftware/beatest</value></metadatas><metadatas><key>cloud</key><value>yes</value></metadatas><metadatas><key>installator</key><value>chef</value></metadatas><metadatas><key>open_ports</key><value>22</value></metadatas><metadatas><key>repository</key><value>svn</value></metadatas><metadatas><key>public</key><value>no</value></metadatas><metadatas><key>dependencies</key><value>tomcat nodejs mysql</value></metadatas></product>'},
    {OPERATION: "Product attributes JSON",           	    CODE: "OK",               BODY: '{"attribute":[{"key":"username","value":"postgres","description":"The administrator username"},{"key":"password","value":"postgres","description":"The administrator password"}]}'},
    {OPERATION: "Product attributes XML",           	    CODE: "OK",               BODY: '<?xml version="1.0" encoding="UTF-8" standalone="yes"?><attributes><attribute><key>username</key><value>postgres</value><description>The administrator username</description></attribute><attribute><key>password</key><value>postgres</value><description>The administrator password</description></attribute></attributes>'},
    {OPERATION: "Product metadatas JSON",       		    CODE: "OK",               BODY: '{"metadata":[{"key":"image","value":"e6c5b19e-f655-4da8-86ea-6dd05be673ef"},{"key":"cookbook_url","value":"https://forge.fi-ware.eu/scmrepos/svn/testbed/trunk/cookbooks/GESoftware/beatest"},{"key":"cloud","value":"yes"},{"key":"installator","value":"chef"},{"key":"open_ports","value":"22"},{"key":"repository","value":"svn"},{"key":"public","value":"no"},{"key":"dependencies","value":"tomcat nodejs mysql"}]}'},
    {OPERATION: "Product metadatas XML",       		  		CODE: "OK",               BODY: '<?xml version="1.0" encoding="UTF-8" standalone="yes"?><metadatas><metadata><key>image</key><value>e6c5b19e-f655-4da8-86ea-6dd05be673ef</value></metadata><metadata><key>cookbook_url</key><value>https://forge.fi-ware.eu/scmrepos/svn/testbed/trunk/cookbooks/GESoftware/beatest</value></metadata><metadata><key>cloud</key><value>yes</value></metadata><metadata><key>installator</key><value>chef</value></metadata><metadata><key>open_ports</key><value>22</value></metadata><metadata><key>repository</key><value>svn</value></metadata><metadata><key>public</key><value>no</value></metadata><metadata><key>dependencies</key><value>tomcat nodejs mysql</value></metadata></metadatas>'},
    {OPERATION: "add Product only name JSON",     	        CODE: "OK",               BODY: '{"name":"Product_test_0001","description":"Product only for test","metadatas":[{"key":"image","value":"df44f62d-9d66-4dc5-b084-2d6c7bc4cfe4"},{"key":"cookbook_url","value":""},{"key":"cloud","value":"yes"},{"key":"installator","value":"chef"},{"key":"open_ports","value":"80 22"}]}'},
    {OPERATION: "add Product only name XML",     	        CODE: "OK",               BODY: '<?xml version="1.0" encoding="UTF-8" standalone="yes"?><product><name>Product_test_0001</name><description>Product only for test</description><metadatas><key>image</key><value>df44f62d-9d66-4dc5-b084-2d6c7bc4cfe4</value></metadatas><metadatas><key>cookbook_url</key><value></value></metadatas><metadatas><key>cloud</key><value>yes</value></metadatas><metadatas><key>installator</key><value>chef</value></metadatas><metadatas><key>open_ports</key><value>80 22</value></metadatas></product>'},
    {OPERATION: "add Product only attributes JSON",	        CODE: "OK",               BODY: '{"name":"Product_test_0001","description":"Product only for test","attributes":[{"key":"username","value":"postgres","description":"The administrator username"},{"key":"password","value":"postgres","description":"The administrator password"}],"metadatas":[{"key":"image","value":"df44f62d-9d66-4dc5-b084-2d6c7bc4cfe4"},{"key":"cookbook_url","value":""},{"key":"cloud","value":"yes"},{"key":"installator","value":"chef"},{"key":"open_ports","value":"80 22"}]}'},
    {OPERATION: "add Product only attributes XML",	        CODE: "OK",               BODY: '<?xml version="1.0" encoding="UTF-8" standalone="yes"?><product><name>Product_test_0001</name><description>Product only for test</description><attributes><key>username</key><value>postgres</value><description>The administrator username</description></attributes><attributes><key>password</key><value>postgres</value><description>The administrator password</description></attributes><metadatas><key>image</key><value>df44f62d-9d66-4dc5-b084-2d6c7bc4cfe4</value></metadatas><metadatas><key>cookbook_url</key><value></value></metadatas><metadatas><key>cloud</key><value>yes</value></metadatas><metadatas><key>installator</key><value>chef</value></metadatas><metadatas><key>open_ports</key><value>80 22</value></metadatas></product>'},
    {OPERATION: "add Product attr and metadatas JSON",      CODE: "OK",               BODY: '{"name":"Product_test_0001","description":"Product only for test","attributes":[{"key":"username","value":"postgres","description":"The administrator username"},{"key":"password","value":"postgres","description":"The administrator password"}],"metadatas":[{"key":"image","value":"e6c5b19e-f655-4da8-86ea-6dd05be673ef"},{"key":"cookbook_url","value":"https://forge.fi-ware.eu/scmrepos/svn/testbed/trunk/cookbooks/GESoftware/beatest"},{"key":"cloud","value":"yes"},{"key":"installator","value":"chef"},{"key":"open_ports","value":"22"},{"key":"repository","value":"svn"},{"key":"public","value":"no"},{"key":"dependencies","value":"tomcat nodejs mysql"}]}'},
    {OPERATION: "add Product attr and metadatas XML",	    CODE: "OK",               BODY: '<?xml version="1.0" encoding="UTF-8" standalone="yes"?><product><name>Product_test_0001</name><description>Product only for test</description><attributes><key>username</key><value>postgres</value><description>The administrator username</description></attributes><attributes><key>password</key><value>postgres</value><description>The administrator password</description></attributes><metadatas><key>image</key><value>e6c5b19e-f655-4da8-86ea-6dd05be673ef</value></metadatas><metadatas><key>cookbook_url</key><value>https://forge.fi-ware.eu/scmrepos/svn/testbed/trunk/cookbooks/GESoftware/beatest</value></metadatas><metadatas><key>cloud</key><value>yes</value></metadatas><metadatas><key>installator</key><value>chef</value></metadatas><metadatas><key>open_ports</key><value>22</value></metadatas><metadatas><key>repository</key><value>svn</value></metadatas><metadatas><key>public</key><value>no</value></metadatas><metadatas><key>dependencies</key><value>tomcat nodejs mysql</value></metadatas></product>'},
   	{OPERATION: "metadata image - one value",     	        CODE: "OK",               BODY: '<metadatas><key>image</key><value>df44f62d-9d66-4dc5-b084-2d6c7bc4cfe4</value>'},
	{OPERATION: "metadata image - several values", 	        CODE: "OK",               BODY: '<metadatas><key>image</key><value>df44f62d-9d66-4dc5-b084-2d6c7bc4cfe4 df44f62d-9d66-1111-2222-2d6c7bc4cfe4</value>'},
    {OPERATION: "metadata_cloud - yes",           	        CODE: "OK",               BODY: '<metadatas><key>cloud</key><value>yes</value></metadatas>'},
    {OPERATION: "metadata_cloud - no",           	 	    CODE: "OK",               BODY: '<metadatas><key>cloud</key><value>no</value></metadatas>'},
	{OPERATION: "metadata_installator - chef",              CODE: "OK",               BODY: '<metadatas><key>installator</key><value>chef</value></metadatas>'},
	{OPERATION: "metadata_installator - puppet",   	        CODE: "OK",               BODY: '<metadatas><key>installator</key><value>puppet</value></metadatas>'},
    {OPERATION: "metadata open_ports - one value", 	        CODE: "OK",               BODY: '<metadatas><key>open_ports</key><value>22</value></metadatas>'},
	{OPERATION: "metadata open_ports - several values",     CODE: "OK",               BODY: '<metadatas><key>open_ports</key><value>22 80 11156</value></metadatas>'},
	{OPERATION: "metadata repository - one value",          CODE: "OK",               BODY: '<metadatas><key>repository</key><value>svn</value></metadatas>'},
	{OPERATION: "metadata_public - yes",                    CODE: "OK",               BODY: '<metadatas><key>public</key><value>yes</value></metadatas>'},
    {OPERATION: "metadata_public - no",                     CODE: "OK",               BODY: '<metadatas><key>public</key><value>no</value></metadatas>'},
	{OPERATION: "metadata dependencies - one value",        CODE: "OK",               BODY: '<metadatas><key>dependencies</key><value>tomcat</value></metadatas>'},
	{OPERATION: "metadata dependencies - several values",   CODE: "OK",               BODY: '<metadatas><key>dependencies</key><value>tomcat mysql nodejs</value></metadatas>'},
	{OPERATION: "delete Product",                           CODE: "No Content",       BODY: ''},
    ####  Product Releases   ####
    {OPERATION: "add Product release JSON",                 CODE: "OK",               BODY: '{"releaseNotes":"version only for test","version":"1.2.3","product":{"name":"Product_test_0002","description":"Product only for test"'},
    {OPERATION: "add Product release XML",                  CODE: "OK",               BODY: '<?xml version="1.0" encoding="UTF-8" standalone="yes"?><productRelease><releaseNotes>version only for test</releaseNotes><version>1.2.3</version><product><name>Product_test_0002</name><description>Product only for test</description>'},
    {OPERATION: "add product release without product",      CODE: "OK",               BODY: '<?xml version="1.0" encoding="UTF-8" standalone="yes"?><productRelease><releaseNotes>version only for test</releaseNotes><version>1.2.3</version><product><name>Product_test_0002_error</name></product></productRelease>'},
    {OPERATION: "Product releases list JSON",               CODE: "OK",               BODY: '{"releaseNotes":"version only for test","version":"","product":{"name":"Product_test_0002"}}'},
    {OPERATION: "Product releases list XML",                CODE: "OK",               BODY: '<productReleases><productRelease><releaseNotes>version only for test</releaseNotes><version></version><product><name>Product_test_0002</name></product></productRelease>'},
    {OPERATION: "Product releases details JSON",            CODE: "OK",               BODY: '{"releaseNotes":"version only for test","version":"","product":{"name":"Product_test_0002"}}'},
    {OPERATION: "Product releases details XML",             CODE: "OK",               BODY: '<?xml version="1.0" encoding="UTF-8" standalone="yes"?><productRelease><releaseNotes>version only for test</releaseNotes><version></version><product><name>Product_test_0002</name></product></productRelease>'},
    {OPERATION: "delete Product release",                   CODE: "No Content",       BODY: ''},
    ####   Install Product - Provisioning    #####
    {OPERATION: "install Product XML",                      CODE: "OK",               BODY: '<description>Install_PEPE product product_new_0001 in  VM testingIvanQA-ivan0001tier-1</description><vdc>testQA</vdc>'},
    {OPERATION: "install Product JSON",                     CODE: "OK",               BODY: '"description":"Install product product_new_0001 in  VM testingIvanQA-ivan0001tier-1","vdc":"testQA"'},
    {OPERATION: "uninstall Product XML",                    CODE: "OK",               BODY: '<description>Uninstall product product_new_0001 in  VM testingIvanQA-ivan0001tier-1</description><vdc>testQA</vdc>'},
    {OPERATION: "uninstall Product JSON",                   CODE: "OK",               BODY: '"description":"Uninstall product product_new_0001 in  VM testingIvanQA-ivan0001tier-1","vdc":"testQA"'},
    ####   Errors    #####
    {OPERATION: "exception",                                CODE: "Bad Request",              BODY: 'Estado HTTP 400 - Bad Request'},
    {OPERATION: "exception",                                CODE: "unauthorized",             BODY: 'Estado HTTP 401 - Unauthorized'},
    {OPERATION: 'exception',                                CODE: 'Not Found',                BODY: 'Estado HTTP 404 - Not Found'},
    {OPERATION: 'Product does not exist',                   CODE: 'Not Found',                BODY: 'exception.ProductReleaseNotFoundException'},
    {OPERATION: "exception",                                CODE: "Bad Method",               BODY: 'Estado HTTP 405 - Method Not Allowed'},
    {OPERATION: "exception",                                CODE: "Not Acceptable",           BODY: 'Estado HTTP 406 - Not Acceptable'},
    {OPERATION: "exception",                                CODE: "Unsupported Media Type",   BODY: 'Estado HTTP 415 - Unsupported Media Type'},
    {OPERATION: "invalid value in product release table",   CODE: "Bad Request",              BODY: 'InvalidProductReleaseException: The Product Release Product_test_0001123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789 is invalid. Please Insert a valid Product Release'},
]

#Constants
ALL_METADATAS = [[{LABEL: 'key', VALUE: 'image'},        {LABEL: 'value', VALUE: 'e6c5b19e-f655-4da8-86ea-6dd05be673ef'}],
                 [{LABEL: 'key', VALUE: 'cookbook_url'}, {LABEL: 'value', VALUE: 'https://forge.fi-ware.eu/scmrepos/svn/testbed/trunk/cookbooks/GESoftware/beatest'}],
                 [{LABEL: 'key', VALUE: 'cloud'},        {LABEL: 'value', VALUE: 'yes'}],
                 [{LABEL: 'key', VALUE: 'installator'},  {LABEL: 'value', VALUE: 'chef'}],
                 [{LABEL: 'key', VALUE: 'open_ports'},   {LABEL: 'value', VALUE: '22'}],
                 [{LABEL: 'key', VALUE: 'repository'},   {LABEL: 'value', VALUE: 'svn'}],
                 [{LABEL: 'key', VALUE: 'public'},       {LABEL: 'value', VALUE: 'no'}],
                 [{LABEL: 'key', VALUE: 'dependencies'}, {LABEL: 'value', VALUE: 'tomcat nodejs mysql'}]]

ATTRIBUTES = [[{LABEL: 'key', VALUE: 'username'}, {LABEL: 'value', VALUE: 'postgres'}, {LABEL: 'description', VALUE: 'The administrator username'}],
              [{LABEL: 'key', VALUE: 'password'}, {LABEL: 'value', VALUE: 'postgres'}, {LABEL: 'description', VALUE: 'The administrator password'}]]

position = [{OPERATION:'installProduct',     CONTENT: 'xml',  POSITION: len('</productInstanceDto>')},
            {OPERATION:'installProduct',     CONTENT: 'json', POSITION: 1},
            {OPERATION:'addProduct',         CONTENT: 'xml',  POSITION: len('</product>')},
            {OPERATION:'addProduct',         CONTENT: 'json', POSITION: 1},
            {OPERATION:'addProductRelease',  CONTENT: 'xml',  POSITION: len('</productReleaseDto>')},
            {OPERATION:'addProductRelease',  CONTENT: 'json', POSITION: 1}]

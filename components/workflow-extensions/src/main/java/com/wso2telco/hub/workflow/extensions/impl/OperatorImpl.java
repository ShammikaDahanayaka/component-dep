/**
 * Copyright (c) 2016, WSO2.Telco Inc. (http://www.wso2telco.com) All Rights Reserved.
 *
 * WSO2.Telco Inc. licences this file to you under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wso2telco.hub.workflow.extensions.impl;

import com.wso2telco.dep.operatorservice.model.Operator;
import com.wso2telco.dep.operatorservice.service.OparatorService;
import com.wso2telco.hub.workflow.extensions.interfaces.OperatorApi;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;


public class OperatorImpl implements OperatorApi {

    private static final Log log = LogFactory.getLog(OperatorImpl.class);

    @Override
    public String getOperators(){
        String operators="";
        try {
            OparatorService operatorService = new OparatorService();
            List<Operator> operatorList = operatorService.retrieveOperatorList();
            for (Operator operator : operatorList) {
                operators = operators + operator.getOperatorName().toLowerCase() + ",";
            }
        }catch(Exception ex){
            log.error("Operator service Exception "+ex);
        }
        return operators;
    }
}

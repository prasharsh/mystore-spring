package com.app.mystore.service.scheduleGenerationAPIHandler;

import java.util.ArrayList;
/*
* Author : Parth Panchal
* B00845025
* Interface confirming toInitiateAPIRequestImpl.
 * */
public interface InitiateAPIRequest {
    String returnScheduleSuggestions(ArrayList<ArrayList<ArrayList<Integer>>> data);
}

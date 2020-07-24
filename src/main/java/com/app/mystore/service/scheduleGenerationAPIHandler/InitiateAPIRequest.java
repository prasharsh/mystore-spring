package com.app.mystore.service.scheduleGenerationAPIHandler;

import java.util.ArrayList;

public interface InitiateAPIRequest {
    String returnScheduleSuggestions(ArrayList<ArrayList<ArrayList<Integer>>> data);
}

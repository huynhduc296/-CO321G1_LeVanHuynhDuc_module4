package com.example.model.service;

import org.springframework.stereotype.Service;

@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Override
    public String convert(String word) {
        String[] Vietnamese = {"xin chào","tốc biến","dịch chuyển","bay","nhảy"};
        String[] English = {"hello","speed","move","ply","jump"};
        boolean check = false;
        String result = "";
        for (int i =0;i<English.length;i++){
            if (English[i].equals(word)){
                result = Vietnamese[i];
                check = true;
            }
        }
        if (!check){
            result = "Not found!";
        }
        return result;
    }
}

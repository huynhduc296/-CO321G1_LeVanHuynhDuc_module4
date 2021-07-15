package com.example.model.service;

import org.springframework.stereotype.Service;

@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Override
    public String convert(String word) {
        String[] vietNam = {"xin chào","tốc biến","dịch chuyển","bay","nhảy"};
        String[] english = {"hello","speed","move","ply","jump"};
        boolean check = false;
        String result = "";
        for (int i =0;i<english.length;i++){
            if (english[i].equals(word)){
                result = vietNam[i];
                check = true;
            }
        }
        if (!check){
            result = "Not found!";
        }
        return result;
    }
}

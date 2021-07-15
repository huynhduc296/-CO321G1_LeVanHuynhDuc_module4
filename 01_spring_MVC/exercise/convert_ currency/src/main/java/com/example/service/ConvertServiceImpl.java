package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements ConvertService{
    @Override
    public double convert(double a, double b, double c) {
        return a*b/c;
    }
}

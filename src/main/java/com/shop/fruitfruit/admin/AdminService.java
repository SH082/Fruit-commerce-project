package com.shop.fruitfruit.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService implements AdminMapper{

    private final AdminMapper adminMapper;


    @Override
    public void insertProduct(HashMap<String, Object> requestData) {}

    @Override
    public void insertPhoto(HashMap<String, Object> requestData) {}

    @Override
    public List<HashMap<String, Object>> selectProductList(HashMap<String, Object> requestData) {
        return adminMapper.selectProductList(requestData);
    }

    @Override
    public void saleStopList(HashMap<String, Object> requestData) {
        adminMapper.saleStopList(requestData);
    }

    @Override
    public void productDelete(HashMap<String, Object> requestData) {
        adminMapper.productDelete(requestData);
    }

    @Override
    public void saleStop(HashMap<String, Object> requestData) {
        adminMapper.saleStop(requestData);
    }

    @Override
    public HashMap<String,Object> countStatus() {

        return adminMapper.countStatus();
    }

    @Override
    public List<HashMap<String, Object>> selectProductListAll() {
        return adminMapper.selectProductListAll();
    }

    @Override
    public HashMap<String, Object> getProductInfo(String id) {
        return adminMapper.getProductInfo(id);
    }

    @Override
    public int countProducts(HashMap<String, Object> requestData) {
        return adminMapper.countProducts(requestData);
    }

    @Override
    public HashMap<String, Object> countProductAll() {
        return adminMapper.countProductAll();
    }

    @Transactional
    public void insertProductAll(HashMap<String, Object> requestData) {
        adminMapper.insertProduct(requestData);
        adminMapper.insertPhoto(requestData);
    }
}

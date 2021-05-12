package com.smbms.Service;

import com.smbms.entity.Provider;
import com.smbms.mapper.ProviderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
@Service
@Transactional(rollbackFor=Exception.class)
public class ProviderServiceImpl implements ProviderService{
    @Autowired
    ProviderMapper providerMapper;

    @Override
    public int add(Provider p) {
//        providerMapper.add(p);
//        if(true){
//            throw new SQLException();
//        }
        return providerMapper.add(p);
    }

    @Override
    public List<Provider> getAllProvider() {
        return providerMapper.getAllProvider();
    }

    @Override
    public List<Provider> getProviderById(Integer id) {
        return providerMapper.getProviderById(id);
    }

    @Override
    public Provider getProvideByCode(String proCode) {
        return providerMapper.getProvideByCode(proCode);
    }

    @Override
    public int updateAll(Provider p) {
        return providerMapper.updateAll(p);
    }

    @Override
    public int delete(int id) {
        return providerMapper.delete(id);
    }
}

package com.smbms.Service;

import com.smbms.entity.Provider;
import com.smbms.mapper.ProviderMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
public interface ProviderService {
    int add(Provider p);
    List<Provider> getAllProvider();
    List<Provider> getProviderById(@Param("id") Integer id);
    Provider getProvideByCode(@Param("userCode") String userCode);
    int updateAll(Provider p);
    int delete(int id);
}

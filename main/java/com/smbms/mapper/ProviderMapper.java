package com.smbms.mapper;

import com.smbms.entity.Provider;
import com.smbms.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProviderMapper {
    int getProviderCounts();
    List<Provider> getAllProvider();
    List<Provider> getProviderById(@Param("id") Integer id);
    Provider getProvideByCode(@Param("proCode") String proCode);
    int add(Provider p);
    int update(Provider p);
    int updateAll(Provider p);
    int delete(int id);
}

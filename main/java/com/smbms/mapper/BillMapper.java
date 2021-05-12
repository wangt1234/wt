package com.smbms.mapper;



import com.smbms.entity.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillMapper {
//    List<Bill> getBillById(Bill bill);
    List<Bill> getBillById(String name);
    List<Bill> getBillById2(@Param("id") Integer id,@Param("isPayment") Integer isPayment,@Param("proName") String proName);
}

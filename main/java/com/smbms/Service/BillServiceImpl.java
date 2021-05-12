package com.smbms.Service;

import com.smbms.entity.Bill;
import com.smbms.mapper.BillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    BillMapper billMapper;
    @Override
    public List<Bill> getBillById2(Integer id, Integer isPayment, String proName) {
        return billMapper.getBillById2(id,isPayment,proName);
    }
}

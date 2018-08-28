package lk.ijse.ibs.dao.custom;

import lk.ijse.ibs.dao.SuperDao;
import lk.ijse.ibs.dto.PaymentDto;

import java.util.ArrayList;

public interface PaymentDao extends SuperDao<PaymentDto> {
    @Override
    default boolean add(PaymentDto dto) throws Exception {
        return false;
    }

    @Override
    default boolean update(PaymentDto dto) throws Exception {
        return false;
    }

    @Override
    default boolean delete(String name) throws Exception {
        return false;
    }

    @Override
    default PaymentDto search(String name) throws Exception {
        return null;
    }

    @Override
    default ArrayList<PaymentDto> getSearched(PaymentDto dto) throws Exception {
        return null;
    }

    @Override
    default ArrayList<PaymentDto> getAll() throws Exception {
        return null;
    }
}

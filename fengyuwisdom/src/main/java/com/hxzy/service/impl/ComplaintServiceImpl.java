package com.hxzy.service.impl;

import com.hxzy.entity.ComplaintDto;
import com.hxzy.mapper.ComplaintDtoMapper;
import com.hxzy.service.ComplaintService;
import com.hxzy.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ComplaintServiceImpl implements ComplaintService {
    @Autowired
    private ComplaintDtoMapper complaintDtoMapper;
    @Override
    public PageBean selectAll() {
        List<ComplaintDto> list = complaintDtoMapper.selectExample();
        return  new PageBean(0, "", list.size(), list);
    }
}

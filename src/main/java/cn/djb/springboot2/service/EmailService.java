package cn.djb.springboot2.service;

import cn.djb.springboot2.domain.GetReport;

public interface EmailService {
    public int send(GetReport report);
}

package com.blackey.component.service.impl;

import com.blackey.component.model.Pic;
import com.blackey.component.repository.PicRepository;
import com.blackey.component.service.PicService;
import com.blackey.jpa.repo.BaseRepository;
import com.blackey.jpa.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 图片
 *
 * @author blackey
 * @date 2018/10/31
 */
@Service
public class PicServiceImpl extends BaseServiceImpl<Pic> implements PicService{

    private PicRepository picRepository;

    @Override
    protected BaseRepository<Pic> getRepo() {
        return picRepository;
    }
}

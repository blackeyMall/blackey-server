package com.blackey.component.service.impl;

import com.blackey.component.model.Material;
import com.blackey.component.repository.MaterialRepository;
import com.blackey.component.service.MaterialService;
import com.blackey.jpa.repo.BaseRepository;
import com.blackey.jpa.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 材料
 *
 * @author blackey
 * @date 2018/10/31
 */
@Service
public class MaterialServiceImpl extends BaseServiceImpl<Material> implements MaterialService{

    private MaterialRepository materialRepository;

    @Override
    protected BaseRepository<Material> getRepo() {
        return materialRepository;
    }
}

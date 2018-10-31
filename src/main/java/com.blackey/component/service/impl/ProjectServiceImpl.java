package com.blackey.component.service.impl;

import com.blackey.component.model.Project;
import com.blackey.component.repository.ProjectRepository;
import com.blackey.component.service.ProjectService;
import com.blackey.jpa.repo.BaseRepository;
import com.blackey.jpa.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 项目
 *
 * @author blackey
 * @date 2018/10/31
 */
@Service
public class ProjectServiceImpl extends BaseServiceImpl<Project> implements ProjectService{

    private ProjectRepository projectRepository;

    @Override
    protected BaseRepository<Project> getRepo() {
        return projectRepository;
    }
}

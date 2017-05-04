package com.qaprosoft.zafira.ws.controller.api;

import com.qaprosoft.zafira.models.db.Project;
import com.qaprosoft.zafira.services.exceptions.ServiceException;
import com.qaprosoft.zafira.services.services.ProjectService;
import com.qaprosoft.zafira.ws.controller.AbstractController;
import com.qaprosoft.zafira.ws.swagger.annotations.ResponseStatusDetails;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@Api(value = "Projects API")
@CrossOrigin
@RequestMapping("api/projects")
public class ProjectsAPIController extends AbstractController {

    @Autowired
    private ProjectService projectService;

    @ResponseStatusDetails
    @ApiOperation(value = "Create project", nickname = "createProject", code = 200, httpMethod = "POST", response = Project.class)
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @Secured({"ROLE_ADMIN"})
    public @ResponseBody
    Project createProject(@RequestBody @Valid Project project) throws ServiceException
    {
        return projectService.createProject(project);
    }

    @ResponseStatusDetails
    @ApiOperation(value = "Delete project", nickname = "deleteProject", code = 200, httpMethod = "DELETE")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
    @Secured({"ROLE_ADMIN"})
    public void deleteProject(@PathVariable(value="id") long id) throws ServiceException
    {
        projectService.deleteProjectById(id);
    }

    @ResponseStatusDetails
    @ApiOperation(value = "Update project", nickname = "updateProject", code = 200, httpMethod = "PUT", response = Project.class)
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @Secured({"ROLE_ADMIN"})
    public @ResponseBody Project updateProject(@RequestBody Project project) throws ServiceException
    {
        return projectService.updateProject(project);
    }

    @ResponseStatusDetails
    @ApiOperation(value = "Get all projects", nickname = "getAllProjects", code = 200, httpMethod = "GET", response = List.class)
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Project> getAllProjects() throws ServiceException
    {
        return projectService.getAllProjects();
    }
}

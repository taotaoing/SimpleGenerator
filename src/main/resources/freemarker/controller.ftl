package ${controllerUrl};

import ${entityUrl}.${entityName};
import ${serviceUrl}.${entityName}Service;
import com.simple.generator.entity.dto.PrimaryKeyIdDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
<#if isSwagger=="true" >
import io.swagger.annotations.Api;
 import io.swagger.annotations.ApiOperation;
</#if>

/**
 * @program: ${project}
 * @description: ${entityComment} API接口层
 * @author: ${author}
 * @create: ${createTime}
 */
 <#if isSwagger=="true" >
@Api(description = "${entityComment}",value="${entityComment}" )
</#if>
@RestController
@RequestMapping("/${objectName}")
public class ${entityName}Controller {
    @Autowired
    private ${entityComment}Service ${objectName}Service;

	@PostMapping("/insert")
   <#if isSwagger=="true" >
    @ApiOperation(value = "新增 ${entityComment}",tags="${entityComment}" )
   </#if>
    public void insert(@RequestBody ${entityName} ${objectName}) {
       ${objectName}Service.insert(${objectName});
    }

    @PostMapping("/update")
    <#if isSwagger=="true" >
     @ApiOperation(value = "修改 ${entityComment}",tags="${entityComment}" )
    </#if>
    public void update(@RequestBody ${entityName} ${objectName}) {
        ${objectName}Service.update(${objectName});
    }

    @PostMapping("/delete")
    <#if isSwagger=="true" >
     @ApiOperation(value = "通过主键id删除 ${entityComment}",tags="${entityComment}" )
    </#if>
    public void delete(@RequestBody PrimaryKeyIdDto primaryKeyIdDto) {
       ${objectName}Service.delete(primaryKeyIdDto.getId());
    }

    @PostMapping("/findById")
    <#if isSwagger=="true" >
     @ApiOperation(value = "通过主键id查询 ${entityComment}",tags="${entityComment}" )
    </#if>
    public ${entityComment} selectById(@RequestBody PrimaryKeyIdDto primaryKeyIdDto) {
       return ${objectName}Service.selectById(primaryKeyIdDto.getId());
    }
}
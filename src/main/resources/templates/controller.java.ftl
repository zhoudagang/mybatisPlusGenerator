package ${package.Controller};

import org.springframework.web.bind.annotation.*;
import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};

import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;

<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * ${table.comment!}
 *
 * @author ${author}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??>:${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>public class ${table.controllerName} extends ${superControllerClass}{
<#else>public class ${table.controllerName} {
</#if>

    @Resource
    private ${table.serviceName} ${(table.serviceName?substring(1))?uncap_first};

    @GetMapping("/list")
    public IPage<${entity}> list(@RequestParam Integer page, @RequestParam Integer pageCount) {
        return ${(table.serviceName?substring(1))?uncap_first}.selectListByPage(page, pageCount);
    }

    @PostMapping("/add")
    public int add(@RequestBody ${entity} ${entity?uncap_first}) {
        return ${(table.serviceName?substring(1))?uncap_first}.insert${entity}(${entity?uncap_first});
    }

    @DeleteMapping("/delete/{id}")
    public int delete(@PathVariable("id") Long id) {
        return ${(table.serviceName?substring(1))?uncap_first}.delete${entity}ById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody ${entity} ${entity?uncap_first}) {
        return ${(table.serviceName?substring(1))?uncap_first}.update${entity}(${entity?uncap_first});
    }

    @GetMapping("/list/{id}")
    public ${entity} select${entity}ById(@PathVariable Long id) {
        return ${(table.serviceName?substring(1))?uncap_first}.select${entity}ById(id);
    }

}
</#if>
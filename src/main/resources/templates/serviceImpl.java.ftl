package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * ${table.comment!}
 *
 * @author ${author}
 */
@Service
@Slf4j
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    @Override
    public  IPage<${entity}> selectListByPage(Integer page, Integer pageCount){
        IPage<${entity}> wherePage = new Page<>(page, pageCount);
        ${entity} where = new ${entity}();

        return baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int insert${entity}(${entity} ${entity?uncap_first}){
        return baseMapper.insert(${entity?uncap_first});
    }

    @Override
    public int delete${entity}ById(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int update${entity}(${entity} ${entity?uncap_first}){
        return baseMapper.updateById(${entity?uncap_first});
    }

    @Override
    public ${entity} select${entity}ById(Long id){
        return  baseMapper.selectById(id);
    }
}
</#if>

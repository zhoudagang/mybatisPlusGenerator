package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * ${table.comment!}
 *
 * @author ${author}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

    /**
     * 查询${table.comment!}分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<${entity}>
     */
     IPage<${entity}> selectListByPage(Integer page, Integer pageCount);

    /**
     * 添加${table.comment!}
     *
     * @param ${entity?uncap_first} ${table.comment!}
     * @return int
     */
     int insert${entity}(${entity} ${entity?uncap_first});

    /**
     * 删除${table.comment!}
     *
     * @param id 主键
     * @return int
     */
     int delete${entity}ById(Long id);

    /**
     * 修改${table.comment!}
     *
     * @param ${entity?uncap_first} ${table.comment!}
     * @return int
     */
     int update${entity}(${entity} ${entity?uncap_first});

    /**
     * id查询数据
     *
     * @param id id
     * @return ${entity}
     */
     ${entity} select${entity}ById(Long id);
}
</#if>

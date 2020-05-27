package ${daoUrl};

import ${entityUrl}.${entityName};
import com.hzcytech.common.page.PageList;
import java.util.List;

/**   
 * @Description:TODO(${entityComment}缓存层)
 * @program: ${project}
 * @version: ${version}
 * @author: ${author}
 * @create: ${createTime}
 */
public interface ${entityName}Dao {

    /**
     * 分页查询 ${entityName} 列表
     * @author ${author}
     * @date ${createTime}
     * @param ${objectName}		${objectName} 查询条件
     * @param pageNum			页码
     * @param pageSize			数量
     * @return com.hzcytech.common.page.PageList<${entityUrl}.${entityName}>
     **/
    PageList<${entityName}> selectPageList(${entityName} ${objectName}, Integer pageNum, Integer pageSize);

    /**
     * 通过主键id查询详情
     * @author ${author}
     * @date ${createTime}
     * @param id		主键id
     * @return ${entityUrl}.${entityName}
     **/
    ${entityName} selectById(Integer id);

    /**
     * 新增 ${objectName}
     * @author ${author}
     * @date ${createTime}
     * @param ${objectName} ${entityComment} 信息
     * @return int
     **/
    int insert(${entityName} ${objectName});

    /**
     * 通过主键id更新 ${entityName} 所有非空字段
     * @author ${author}
     * @date ${createTime}
     * @param ${objectName} ${entityComment} 信息
     * @return int
     **/
    int update(${entityName} ${objectName});

    /**
     * 通过主键id逻辑删除 ${entityName}
     * @author ${author}
     * @date ${createTime}
     * @param id		主键id
     * @return int
     **/
    int delete(Integer id);

    /**
     * 通过条件查询 ${entityName} （不分页）
     * @author ${author}
     * @date ${createTime}
     * @param param		${entityComment} 信息
     * @return int
     **/
    List<${entityName}> selectParameter(${entityName} param);
}
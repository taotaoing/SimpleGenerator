package ${daoImplUrl};

import ${entityUrl}.${entityName};
import ${mapperUrl}.${entityName}Mapper;
import ${daoUrl}.${entityName}Dao;
import com.github.pagehelper.PageHelper;
import com.simple.generator.common.PageList;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Description:TODO(${entityComment}缓存层实现)
 * @program: ${project}
 * @version: ${version}
 * @author: ${author}
 * @create: ${createTime}
 */
@Repository
public class ${entityName}DaoImpl implements ${entityName}Dao  {
    @Autowired
    private ${entityName}Mapper ${objectName}Mapper;

    @Override
    public PageList<${entityName}> selectPageList(${entityName} ${objectName}, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<${entityName}> list = ${objectName}Mapper.select(${objectName});
        return new PageList(list);
   }

    @Override
    public ${entityName} selectById(Integer id) {
       return ${objectName}Mapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(${entityName} ${objectName}) {
       return ${objectName}Mapper.insert(${objectName});
    }

    @Override
    public int update(${entityName} ${objectName}) {
       return ${objectName}Mapper.updateByPrimaryKeySelective(${objectName});
    }

    @Override
    public int delete(Integer id) {
        ${entityName} ${objectName} = selectById(id);
        if (Objects.nonNull(${objectName})) {
            ${objectName}.setUpdateTime(new Date());
            ${objectName}.setIsDeleted(true);
            return update(${objectName});
        }
       return 0;
    }

    @Override
    List<${entityName}> selectParameter(${entityName} param) {
        return ${objectName}Mapper.select(param);
    }
}
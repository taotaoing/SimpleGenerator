package ${serviceImplUrl};

import ${entityUrl}.${entityName};
import ${daoUrl}.${entityName}Dao;
import ${serviceUrl}.${entityName}Service;
import com.simple.generator.common.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**   
 * @Description:TODO(${entityComment}服务实现)
 * @program: ${project}
 * @version: ${version}
 * @author: ${author}
 * @create: ${createTime}
 */
@Service
public class ${entityName}ServiceImpl implements ${entityName}Service  {
    @Autowired
   private ${entityName}Dao ${objectName}Dao;

    @Override
    public PageList<${entityName}> selectPageList(${entityName} ${objectName}, Integer pageNum, Integer pageSize) {
        return ${objectName}Dao.selectPageList(${objectName},pageNum, pageSize);
    }

    @Override
    public ${entityName} selectById(Integer id) {
       return ${objectName}Dao.selectById(id);
    }

    @Override
    public int insert(${entityName} ${objectName}) {
       ${objectName}.setCreateTime(new Date());
       ${objectName}.setUpdateTime(new Date());
       ${objectName}.setIsDeleted(false);
       return ${objectName}Dao.insert(${objectName});
    }

    @Override
    public int update(${entityName} ${objectName}) {
       ${objectName}.setCreateTime(null);
       ${objectName}.setUpdateTime(new Date());
       ${objectName}.setIsDeleted(null);
       return ${objectName}Dao.update(${objectName});
    }

    @Override
    public int delete(Integer id) {
       return ${objectName}Dao.delete(id);
    }

    @Override
    List<${entityName}> selectParameter(${entityName} param) {
        return ${objectName}Mapper.select(param);
    }
}
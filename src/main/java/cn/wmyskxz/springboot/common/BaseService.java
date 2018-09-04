package cn.wmyskxz.springboot.common;


import java.util.List;

public abstract class BaseService<T extends BaseEntity, K> {
    public BaseService() {
    }

   public abstract BaseDao<T> getDao();
    /*
        public int insert(T t) throws Exception {
            return this.getDao().insert(t)        }

        public int insertSelective(T t) throws Exception {
            return this.getDao().insertSelective(t);
        }

        public int updateByPrimaryKey(T t) throws Exception {
            return this.getDao().updateByPrimaryKey(t);
        }

        public int updateByPrimaryKeySelective(T t) throws Exception {
            return this.getDao().updateByPrimaryKeySelective(t);
        }

        public T selectByPrimaryKey(K value) throws Exception {
            return this.getDao().selectByPrimaryKey(value);
        }

        public void deleteByPrimaryKey(K value) throws Exception {
            this.getDao().deleteByPrimaryKey(value);
        }

        public List<T> queryByList(BasePage page) throws Exception {
            return this.getDao().queryByList(page);
        }
    */
    public int queryByCount(BasePage page) throws Exception {
        return this.getDao().queryByCount(page);
    }
    public int updateByPrimaryKey(T t) throws Exception {
        return this.getDao().updateByPrimaryKey(t);
    }

    public List<T> queryByPage(BasePage page) throws Exception {
        Integer rowCount = this.queryByCount(page);
        page.getPager().setRowCount(rowCount);
        return this.getDao().queryByPage(page);
    }

/*    public T queryBySingle(BasePage page) throws Exception {
        page.setPageSize(1);
        List<T> results = this.getDao().queryByList(page);
        return null != results && results.size() != 0 ? (BaseEntity)results.get(0) : null;
    }*/
}

package com.teach.android.educationonline.http.database;

import android.database.sqlite.SQLiteException;

import com.teach.android.educationonline.log.MyLog;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.Collection;
import java.util.List;

/**
 * 数据库操作管理
 * Created by zheng on 2017/11/2.
 */

public abstract class DBManager<M, K> implements IDatabase<M, K>{
    @Override
    public boolean insert(@NotNull M m) {
        try {
            getAbstractDao().insert(m);
        }catch (SQLiteException e){
            MyLog.e(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean insertOrReplace(@NotNull M m) {
        try {
            getAbstractDao().insertOrReplace(m);
        }catch (SQLiteException e){
            MyLog.e(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean insertInTx(@NotNull List<M> list) {
        try {
            getAbstractDao().insertInTx(list);
        } catch (SQLiteException e) {
            MyLog.e(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean insertOrReplaceInTx(@NotNull List<M> list) {
        try {
            getAbstractDao().insertOrReplaceInTx(list);
        } catch (SQLiteException e) {
            MyLog.e(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(@NotNull M m) {
        try {
            getAbstractDao().delete(m);
        } catch (SQLiteException e) {
            MyLog.e(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteByKey(@NotNull K key) {
        try {
            getAbstractDao().deleteByKey(key);
        } catch (SQLiteException e) {
            MyLog.e(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteInTx(@NotNull List<M> list) {
        try {
            getAbstractDao().deleteInTx(list);
        } catch (SQLiteException e) {
            MyLog.e(e);
            return false;
        }
        return true;
    }

    @SafeVarargs
    @Override
    public final boolean deleteByKeyInTx(@NotNull K... key) {
        try {
            getAbstractDao().deleteByKeyInTx(key);
        } catch (SQLiteException e) {
            MyLog.e(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteAll() {
        try {
            getAbstractDao().deleteAll();
        } catch (SQLiteException e) {
            MyLog.e(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean update(@NotNull M m) {
        try {
            getAbstractDao().update(m);
        } catch (SQLiteException e) {
            MyLog.e(e);
            return false;
        }
        return true;
    }

    @SafeVarargs
    @Override
    public final boolean updateInTx(@NotNull M... m) {
        try {
            getAbstractDao().updateInTx(m);
        } catch (SQLiteException e) {
            MyLog.e(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean updateInTx(@NotNull List<M> list) {
        try {
            getAbstractDao().updateInTx(list);
        } catch (SQLiteException e) {
            MyLog.e(e);
            return false;
        }
        return true;
    }

    @Override
    public M load(@NotNull K key) {
        try {
            return getAbstractDao().load(key);
        } catch (SQLiteException e) {
            MyLog.e(e);
            return null;
        }
    }

    @Override
    public List<M> loadAll() {
        return getAbstractDao().loadAll();
    }

    @Override
    public boolean refresh(@NotNull M m) {
        try {
            getAbstractDao().refresh(m);
        } catch (SQLiteException e) {
            MyLog.e(e);
            return false;
        }
        return true;
    }

    @Override
    public void runInTx(@NotNull Runnable runnable) {
        try {
            getAbstractDao().getSession().runInTx(runnable);
        } catch (SQLiteException e) {
            MyLog.e(e);
        }
    }

    @Override
    public abstract AbstractDao<M, K> getAbstractDao();

    @Override
    public QueryBuilder<M> queryBuilder() {
        return getAbstractDao().queryBuilder();
    }

    @Override
    public List<M> queryRaw(@NotNull String where, String... selectionArg) {
        return getAbstractDao().queryRaw(where,selectionArg);
    }

    @Override
    public Query<M> queryRawCreate(@NotNull String where, @NotNull Object... selectionArg) {
        return getAbstractDao().queryRawCreate(where, selectionArg);
    }

    @Override
    public Query<M> queryRawCreateListArgs(@NotNull String where, Collection<Object> selectionArg) {
        return getAbstractDao().queryRawCreateListArgs(where,selectionArg);
    }
}

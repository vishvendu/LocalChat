package com.example.vishvendu.localchat.database;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CHATS".
*/
public class ChatsDao extends AbstractDao<Chats, Long> {

    public static final String TABLENAME = "CHATS";

    /**
     * Properties of entity Chats.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property ChatDataUserOne = new Property(1, String.class, "chatDataUserOne", false, "CHAT_DATA_USER_ONE");
        public final static Property ChatDataRandomeUser = new Property(2, String.class, "chatDataRandomeUser", false, "CHAT_DATA_RANDOME_USER");
        public final static Property ChatId = new Property(3, Long.class, "ChatId", false, "CHAT_ID");
    }

    private Query<Chats> user_UserOneQuery;
    private Query<Chats> user_RandomUserQuery;

    public ChatsDao(DaoConfig config) {
        super(config);
    }
    
    public ChatsDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CHATS\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"CHAT_DATA_USER_ONE\" TEXT NOT NULL ," + // 1: chatDataUserOne
                "\"CHAT_DATA_RANDOME_USER\" TEXT NOT NULL ," + // 2: chatDataRandomeUser
                "\"CHAT_ID\" INTEGER);"); // 3: ChatId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CHATS\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Chats entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getChatDataUserOne());
        stmt.bindString(3, entity.getChatDataRandomeUser());
 
        Long ChatId = entity.getChatId();
        if (ChatId != null) {
            stmt.bindLong(4, ChatId);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Chats entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getChatDataUserOne());
        stmt.bindString(3, entity.getChatDataRandomeUser());
 
        Long ChatId = entity.getChatId();
        if (ChatId != null) {
            stmt.bindLong(4, ChatId);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Chats readEntity(Cursor cursor, int offset) {
        Chats entity = new Chats( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // chatDataUserOne
            cursor.getString(offset + 2), // chatDataRandomeUser
            cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3) // ChatId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Chats entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setChatDataUserOne(cursor.getString(offset + 1));
        entity.setChatDataRandomeUser(cursor.getString(offset + 2));
        entity.setChatId(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Chats entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Chats entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Chats entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "userOne" to-many relationship of User. */
    public List<Chats> _queryUser_UserOne(Long ChatId) {
        synchronized (this) {
            if (user_UserOneQuery == null) {
                QueryBuilder<Chats> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.ChatId.eq(null));
                user_UserOneQuery = queryBuilder.build();
            }
        }
        Query<Chats> query = user_UserOneQuery.forCurrentThread();
        query.setParameter(0, ChatId);
        return query.list();
    }

    /** Internal query to resolve the "randomUser" to-many relationship of User. */
    public List<Chats> _queryUser_RandomUser(Long ChatId) {
        synchronized (this) {
            if (user_RandomUserQuery == null) {
                QueryBuilder<Chats> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.ChatId.eq(null));
                user_RandomUserQuery = queryBuilder.build();
            }
        }
        Query<Chats> query = user_RandomUserQuery.forCurrentThread();
        query.setParameter(0, ChatId);
        return query.list();
    }

}

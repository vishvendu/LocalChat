package com.example.vishvendu.localchat.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.DaoException;

/**
 * Created by vishvendu on 22/11/17.
 */

@Entity
public class User {

    @Id(autoincrement = true)
    private Long id;

    @Property
    private String UserType;

    @ToMany(referencedJoinProperty = "ChatId")
    private List<Chats> userOne;

    @ToMany(referencedJoinProperty = "ChatId")
    private List<Chats> randomUser;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1507654846)
    private transient UserDao myDao;

    @Generated(hash = 1631864406)
    public User(Long id, String UserType) {
        this.id = id;
        this.UserType = UserType;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserType() {
        return this.UserType;
    }

    public void setUserType(String UserType) {
        this.UserType = UserType;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1414376835)
    public List<Chats> getUserOne() {
        if (userOne == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ChatsDao targetDao = daoSession.getChatsDao();
            List<Chats> userOneNew = targetDao._queryUser_UserOne(id);
            synchronized (this) {
                if (userOne == null) {
                    userOne = userOneNew;
                }
            }
        }
        return userOne;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 437641058)
    public synchronized void resetUserOne() {
        userOne = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1176280246)
    public List<Chats> getRandomUser() {
        if (randomUser == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ChatsDao targetDao = daoSession.getChatsDao();
            List<Chats> randomUserNew = targetDao._queryUser_RandomUser(id);
            synchronized (this) {
                if (randomUser == null) {
                    randomUser = randomUserNew;
                }
            }
        }
        return randomUser;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 65720709)
    public synchronized void resetRandomUser() {
        randomUser = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 2059241980)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserDao() : null;
    }

  



}

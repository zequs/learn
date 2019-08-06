package com.zequs.demo.se.designpattern.pattern.prototype.clone;

import org.springframework.beans.BeanUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 01 Exp $
 */
public class CloneSheep implements Cloneable, Serializable {
    private Sheep sheep;
    private String describe;

    public Sheep getSheep() {
        return sheep;
    }

    public void setSheep(Sheep sheep) {
        this.sheep = sheep;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    /**
     * 浅拷贝，当有引用类型时，拷贝不适用，因为拷贝的对象中引用类型都是指向同一个，一个修改后其他拷贝的也修改了。
     * @return
     * @throws CloneNotSupportedException
     */
   /* @Override
    protected Object clone() throws CloneNotSupportedException {
        Object cloneSheep = null;
        cloneSheep =  super.clone();
        return cloneSheep;
    }*/

    /**
     *  深拷贝，把引用类型，复制一份，不然拷贝的引用都是指向同一个，一个修改后其他拷贝的也修改了。
     *  引用拷贝不一定要clone()方法，也可以使用其他方法
     * @return
     * @throws CloneNotSupportedException
     */
   /* @Override
    protected Object clone() throws CloneNotSupportedException {
        CloneSheep cloneSheep = (CloneSheep) super.clone();
        cloneSheep.sheep = (Sheep) cloneSheep.sheep.clone();
        return cloneSheep;
    }*/

    /**
     * 使用Spring beanUtils复制引用成员变量
     * @return
     * @throws CloneNotSupportedException
     */
    /*@Override
    protected Object clone() throws CloneNotSupportedException {
        CloneSheep cloneSheep = (CloneSheep) super.clone();
        //如果是数组的话，可以用System.arraycopy()
        BeanUtils.copyProperties(cloneSheep.sheep,new Sheep());
        cloneSheep.setSheep(sheep);
        return cloneSheep;
    }*/

    /**
     * 序列化克隆对象,对象都需要实现Serializable，引用类型多的话，每个引用复制太麻烦，使用序列化克隆。
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        ByteArrayInputStream bis = null;
        ByteArrayOutputStream bos = null;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        try {
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            CloneSheep cloneSheep = (CloneSheep) ois.readObject();
            return cloneSheep;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return "CloneSheep{" +
                "sheep=" + sheep +
                ", describe='" + describe + '\'' +
                ", hashCode='" + this.hashCode() + '\'' +
                '}';
    }
}

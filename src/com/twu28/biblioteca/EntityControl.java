package com.twu28.biblioteca;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: enthudrives
 * Date: 7/23/12
 * Time: 11:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class EntityControl
{
    ArrayList<Entity> list =new ArrayList<Entity>();
    protected String getList()
    {
        String entitylist="";
        for(Entity entity:list)
            entitylist+=entity.toString()+"\n";
        return entitylist;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

/**
 *
 * @author Labing
 */
public interface Queue
{
    /**
     * 
     * @return Object
     */
    public boolean isEmpty();
    
    /**
     * 
     * @return Object
     */
    public Object getFrontElement();
    
    /**
     * 
     * @return Object
     */
    public Object getRearElement();
    
    /**
     * 
     * @param theObject Object 
     */
    public void put(Object theObject);
    
    /**
     * 
     * @return Object
     */
    public Object remove();
}
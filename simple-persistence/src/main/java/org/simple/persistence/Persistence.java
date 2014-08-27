package org.simple.persistence;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Persistence {
	private Session sesion; 
    private Transaction tx;  

    public void guarda(Object contacto) throws HibernateException 
    { 
        //String id = 0;  

        try 
        { 
            iniciaOperacion(); 
            sesion.save(contacto); 
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        }  
    }  

    public void actualiza(Object contacto) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.update(contacto); 
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        } 
    }  

    public void elimina(Object contacto) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.delete(contacto); 
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        } 
    } 

    private void iniciaOperacion() throws HibernateException 
    { 
        sesion = HibernateUtil.getSessionFactory().openSession(); 
        tx = sesion.beginTransaction(); 
    }  

    private void manejaExcepcion(HibernateException he) throws HibernateException 
    { 
        tx.rollback(); 
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he); 
    } 
}

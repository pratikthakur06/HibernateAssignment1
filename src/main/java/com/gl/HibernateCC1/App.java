package com.gl.HibernateCC1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gl.HibernateCC1.config.HibernateConfig;
import com.gl.HibernateCC1.entity.Teacher;

/**
 * Hello world!
 *
 */
public class App {

	private static SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

	public static void main(String[] args) {
		System.out.println("Configuration Loaded...");

		Teacher teacher = new Teacher("Pratik", "Thakur", "pratik@gl.com");

//		System.out.println(insertTeacher(teacher));

//		teacher.setId(2);
//		teacher.setF_Name("Preeti");
//		teacher.setEmail("preeti@gl.com");
//		System.out.println(updateTeacher(teacher));

//		teacher.setId(1);
//		deleteTeacher(teacher);

//		System.out.println(getTeacherById(2));

//		for (Teacher t : getAllTeachers()) {
//			System.out.println(t);
//		}
	}

	public static int insertTeacher(Teacher teacher) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(teacher);
		tx.commit();
		session.close();
		return teacher.getId();
	}

	public static Teacher updateTeacher(Teacher teacher) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Teacher updatedTeacher = session.merge(teacher);
		tx.commit();
		session.close();
		return updatedTeacher;
	}

	public static void deleteTeacher(Teacher teacher) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.remove(teacher);
		tx.commit();
		session.close();
	}

	public static Teacher getTeacherById(int id) {
		Session session = sessionFactory.openSession();
		Teacher teacher = session.get(Teacher.class, id);
		session.close();
		return teacher;
	}

	public static List<Teacher> getAllTeachers() {
		Session session = sessionFactory.openSession();
		List<Teacher> teachers = session.createQuery("select t from Teacher t", Teacher.class).getResultList();
		session.close();
		return teachers;
	}
}

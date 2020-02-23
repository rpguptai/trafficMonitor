package com.iot.app.springboot.dao;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.iot.app.springboot.dao.entity.WindowTrafficData;


@Repository
public interface WindowTrafficDataRepository extends CassandraRepository<WindowTrafficData,Integer>{
	
	@Query("SELECT * FROM traffickeyspace.window_traffic WHERE recorddate = ?0 ALLOW FILTERING")
	 Iterable<WindowTrafficData> findTrafficDataByDate(String date);

}

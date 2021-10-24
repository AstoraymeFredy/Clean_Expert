package pe.edu.upc.spring.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Room;
import pe.edu.upc.spring.repository.iRoomRepository;
import pe.edu.upc.spring.service.iRoomService;

@Service
public class RoomServiceImpl  implements iRoomService{

	@Autowired
	private iRoomRepository dRoom;
	
	@Override
	@Transactional(readOnly = true)
	public List<Room> listRooms () {
		return dRoom.findAll();
	}
	
}

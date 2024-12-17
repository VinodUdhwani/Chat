package com.chat.Chat.repositories;

import com.chat.Chat.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,String> {
    Room findByRoomId(String roomId);
}

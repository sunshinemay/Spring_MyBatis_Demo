package demo.dao.impl;

import org.springframework.stereotype.Repository;

import demo.dao.MessageDao;
import demo.model.Message;

@Repository
public class MessageDaoImpl extends GenericDaoImpl<Message, Integer> implements MessageDao {
}
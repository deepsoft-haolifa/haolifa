package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.vo.QuickStartVO;
import com.deepsoft.haolifa.model.vo.TodoItemVO;

import java.util.List;

public interface HomeApiService {

    List<QuickStartVO> getQuickStartMenu();

    List<TodoItemVO> getTodoItems();

}

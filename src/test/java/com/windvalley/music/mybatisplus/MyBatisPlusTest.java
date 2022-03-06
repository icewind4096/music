package com.windvalley.music.mybatisplus;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisPlusTest {
//    @Autowired
//    private UserMapper userMapper;
//
//    @Test
//    public void testSelectList(){
//        List<User> userList = userMapper.selectList(null);
//        for (User user: userList){
//            System.out.println(user.toString());
//        }
//    }
//
//    @Test
//    public void testInsert(){
//        User user = new User();
//        user.setUserName("张三");
//        user.setNickName("张三NickName");
//        user.setPassword("password");
//        user.setEnabled(true);
//        user.setLocked(true);
//        user.setGender(Gender.FEMALE);
//        user.setLastLoginIp("192.168.0.1");
//        user.setLastLoginTime(new Date());
//        System.out.println(userMapper.insert(user));
//    }
//
//    @Test
//    public void deleById(){
//        int result = userMapper.deleteById(12L);
//        System.out.print(result);
//    }
//
//    @Test
//    public void deleByMap(){
//        Map<String, Object> conditionMap = new HashMap<>();
//        conditionMap.put("username", "张三");
//        conditionMap.put("nickName", "昵称");
//        int result = userMapper.deleteByMap(conditionMap);
//        System.out.print(result);
//    }
//
//    @Test
//    public void deleByList(){
//        List<Long> ids = new ArrayList<>();
//        ids.add(1l);
//        ids.add(3L);
//        int result = userMapper.deleteBatchIds(ids);
//        System.out.print(result);
//    }
//
//    @Test
//    public void customizeFunction(){
////        Map<String, Object> map = userMapper.selectMapById(10l);
////        System.out.print(map);
//    }
//
//    @Test
//    public void pageSelect(){
//        Page<User> page = new Page<User>(1, 5);
//
//        Page<User> pageParam = userMapper.selectPage(page, null);
//
//        List<User> userList = pageParam.getRecords();
//
//        for (User user: userList){
//            System.out.println(user.toString());
//        }
//
//        pageParam.getTotal(); //总记录数
//        pageParam.getPages(); //总页数
//        pageParam.getCurrent(); //当前页码
//        pageParam.getSize(); //每页记录数
//        pageParam.hasNext(); //有下一页
//        pageParam.hasPrevious(); //有上一页
//    }
//
//    @Test
//    public void pageSelectByMap(){
//        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.select("id", "name", "nackname");
//
//        Page<Map<String, Object>> page = new Page<>(1, 5);
//        Page<Map<String, Object>> pageParam = userMapper.selectMapsPage(page, queryWrapper);
//
//        List<Map<String, Object>> records = pageParam.getRecords();
//
//        pageParam.getTotal(); //总记录数
//        pageParam.getPages(); //总页数
//        pageParam.getCurrent(); //当前页码
//        pageParam.getSize(); //每页记录数
//        pageParam.hasNext(); //有下一页
//        pageParam.hasPrevious(); //有上一页
//    }
}

package com.fore.house.controller;

import com.condition.UsersCondition;
import com.exceptionHandler.MyExceptionHandler;
import com.fore.house.service.ForeHouseService;
import com.github.pagehelper.PageInfo;
import com.pojo.House;
import com.pojo.HouseMoreInfo;
import com.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2019-12-27 15:33:59
 */
@Controller
@RequestMapping("/h")
public class ForeHouseController {
    @Autowired
    ForeHouseService foreHouseService;

    @RequestMapping("/getHouse")          //获取前台图片资源@RequestParam("pfile")不能省略
    public String addHouse(House house, @RequestParam(value = "pfile", required = false) MultipartFile pfile, HttpSession session, Model model){
        //设置房屋id
        String id = System.currentTimeMillis()+"";
        house.setId(id);
        //设置用户Uid
        Users users = (Users) session.getAttribute("fusers");
        if(users == null){
            return "fore/timeout";
        }
        house.setUserId(users.getId());
        house.setIsdel(0);
        house.setIspass(0);
        //处理图片，存在数据库中的应该为图片的路径，图片应该存在于图片服务器
        //获取图片的文件名
        if (pfile !=null && !pfile.isEmpty()) {
            String originalFilename = pfile.getOriginalFilename();
            //截取图片后缀名
            assert originalFilename != null;
            String path1 = getPath(originalFilename);
            String path2 = "G:/upLoadFile/";
            /*nginx做图片代理服务器*/
            String path =path2 + path1;
            //把图片存到电脑的这个路径下面
            File file = new File(path);
            try {
                pfile.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //图片存到数据库中的路径
            house.setPath(path1);
        }
        boolean b = foreHouseService.addHouseInfo(house);
        if(b){
            model.addAttribute("msg03", "success");
        }else {
            model.addAttribute("msg03", "fail");
        }
        return "fore/fabu";
    }

    //查到当前登录用户的所有房屋信息，显示到个人主页上
    @RequestMapping("/showHouse")
    public String showHouse(@RequestParam(defaultValue = "1") Integer pageNum, HttpSession session, Model model){
        Users users =(Users) session.getAttribute("fusers");
        if(users == null){
            return "fore/timeout";
        }
        //可以默认一个页大小
        Integer pageSize = 5;
        PageInfo<HouseMoreInfo> pageInfo = foreHouseService.showHouse(pageNum, pageSize, users.getId());
        model.addAttribute("pageInfo", pageInfo);
        return "fore/guanli";
    }

    //修改房屋信息upHouse，先查出房屋信息用于回显
    @RequestMapping("/upHouse/{houseId}")
    public String upHouse(@PathVariable("houseId") String houseId, Model model){
        System.err.println(houseId);
        HouseMoreInfo house = foreHouseService.getHouseByHouseId(houseId);
        System.err.println(house);
        model.addAttribute("house", house);
        return "fore/fabu2";
    }

    //最终接受修改房屋的请求
    @RequestMapping("/finalUpHouse")          //获取前台图片资源@RequestParam("pfile")不能省略
    public String finalUpHouse(String id, House house, @RequestParam(value = "pfile", required = false) MultipartFile pfile, HttpSession session, Model model){
        //根据图片路径删除旧的图片
        String path3 = "G:/upLoadFile/" + house.getPath();
        System.err.println(path3);
        File file1 = new File(path3);
        file1.delete();
        //设置房屋id
        house.setId(id);
        //设置用户Uid
        Users users = (Users) session.getAttribute("fusers");
        house.setUserId(users.getId());
        house.setIsdel(0);
        house.setIspass(0);
        //处理图片，存在数据库中的应该为图片的路径，图片应该存在于图片服务器
        //获取图片的文件名
        if (pfile !=null && !pfile.isEmpty()) {
            String originalFilename = pfile.getOriginalFilename();
            //截取图片后缀名
            assert originalFilename != null;
            String path1 = getPath(originalFilename);
            String path2 = "G:/upLoadFile/";
            /*nginx做图片代理服务器*/
            String path =path2 + path1;
            //把图片存到电脑的这个路径下面
            File file = new File(path);
            try {
                pfile.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //图片存到数据库中的路径
            house.setPath(path1);
        }
        boolean b = foreHouseService.upHouseInfo(house);
        if(b){
            model.addAttribute("msg04", "success");
        }else {
            model.addAttribute("msg04", "fail");
        }
        return "fore/fabu2";
    }

    private String getPath(String originalFilename) {
        String substringEndName = originalFilename.substring(originalFilename.lastIndexOf("."));
        Calendar calendar = Calendar.getInstance();
        String year = calendar.get(Calendar.YEAR) + "";
        String month = calendar.get(Calendar.MONTH) + 1 + "";
        String day = calendar.get(Calendar.DAY_OF_MONTH) + "";
        String hour = calendar.get(Calendar.HOUR_OF_DAY) + "";
        String minute = calendar.get(Calendar.MINUTE) + "";
        String second = calendar.get(Calendar.SECOND) + "";
        return year + month + day + hour + minute + second + substringEndName;
    }

    //下架该房源，把isdel设为1
    @RequestMapping("/downHouse")
    public String downHouse(String houseId){
        Integer i = foreHouseService.downHouseService(houseId);
        if(i>0){
            return "redirect:/h/showHouse";
        }else
            return "fore/err";
    }

    //显示房屋详细信息，查询单条
    @RequestMapping("/detailsHouse")
    public String detailsHouse(String houseId, Model model){
        HouseMoreInfo house = foreHouseService.detailsHouseService(houseId);
        if(house !=null){
            model.addAttribute("house", house);
            return "fore/details";
        }else
            return "fore/err";
    }

    /**
     * 分页动态查到当前登录用户的所有房屋信息，显示到网站的主页上给浏览者看
     *
     * @param pageNum 当前页
     * @param model 模型封装数据
     * @param condition 查询条件
     * @return 返回房屋信息显示主页
     */
    @RequestMapping("/listHouse")
    public String listHouse(@RequestParam(defaultValue = "1") Integer pageNum, Model model, UsersCondition condition){
        if(true){
            throw new MyExceptionHandler("400", "服务器异常");
        }
//        int j = 10/0;
       /* Users users =(Users) session.getAttribute("users");
        if(users == null){
            return "/page/timeout.html";
        }*/
        //可以默认一个页大小
        System.err.println(condition);
        model.addAttribute("condition", condition);
        Integer pageSize = 5;
        PageInfo<HouseMoreInfo> pageInfo = foreHouseService.showHouse5(pageNum, pageSize, condition);
        model.addAttribute("pageInfo", pageInfo);
        return "fore/list";
    }
}






















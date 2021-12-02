package com.jincou.validation.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 *  用户实体
 *
 * @author xub
 * @date 2021/11/29 下午9:31
 */
@Data
@Builder
@ApiModel("用户实体类")
@NoArgsConstructor
@AllArgsConstructor
public class UserGroupsDTO {


    @ApiModelProperty("用户id")
    @NotNull(groups = Update.class)
    @Null(groups = Save.class)
    private Long userId;

    @ApiModelProperty("用户名")
    @NotNull
    @Length(min = 2, max = 10)
    private String userName;

    @ApiModelProperty("年龄")
    @Min(1)
    @Max(99)
    private int age;


    @ApiModelProperty("兴趣")
    @NotNull
    @Valid
    private Interest interest;

    /**
     * 兴趣实体
     */
    @ApiModel("兴趣实体")
    @Data
    public static class Interest {

        @ApiModelProperty("兴趣Id")
        @Min(1)
        private Long interestId;

        @ApiModelProperty("兴趣名称")
        @NotNull
        @Length(min = 2, max = 10)
        private String interestName;

    }

    /**
     * 保存的时候校验分组
     */
    public interface Save {
    }

    /**
     * 更新的时候校验分组
     */
    public interface Update {
    }
}

package org.example.common.db.procedure.paramIn;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Uinp1311Input {
    /**
     * 会社区分
     */
    @TableField("ps_compkb")
    private String compkb;
    /**
     * 体系区分
     */
    @TableField("ps_qtaikeikb")
    private String qtaikeikb;
    /**
     * 社員番号
     */
    @TableField("ps_shainno")
    private String shainno;
}

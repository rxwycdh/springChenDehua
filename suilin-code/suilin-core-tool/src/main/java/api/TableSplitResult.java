package api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value="TableSplitResult对象", description="分页信息")
public class TableSplitResult<T> implements Serializable {

	private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "当前页码",example = "1", required = true)
    private Integer page;
    @ApiModelProperty(value = "总记录数", example = "0", required = true)
    private Long total;
    @ApiModelProperty(value = "结果集")
    private List<T> rows;
 
 
    public TableSplitResult() {
    }
 
    public TableSplitResult(Integer page, Long total, List<T> rows) {
        this.page = page;
        this.total = total;
        this.rows = rows;
    }

    public TableSplitResult(List<T> rows) {
        this.page = 1;
        this.total = (long) rows.size();
        this.rows = rows;
    }

    public Integer getPage() {
        return page;
    }
 
    public void setPage(Integer page) {
        this.page = page;
    }
 
    public Long getTotal() {
        return total;
    }
 
    public void setTotal(Long total) {
        this.total = total;
    }
 
    public List<T> getRows() {
        return rows;
    }
 
    public void setRows(List<T> rows) {
        this.rows = rows;
    }

}

package api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * boostrap table post 参数
 * @author analysis
 *
 */
@ApiModel(value="Tablepar对象", description="分页栏")
public class Tablepar {
	@ApiModelProperty(value = "当前页码",example = "1", required = true)
	private int pageNum;
	@ApiModelProperty(value = "每页数量", example = "10", required = true)
	private int pageSize;
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}

package test;

import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.graph.exe.Token;


public class HelloWorldTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     ProcessDefinition processDefinition = ProcessDefinition.parseXmlResource("helloworld/processdefinition.xml");
	 ProcessInstance processInstance = new ProcessInstance(processDefinition);
	 //得到流程实例
	 Token token=processInstance.getRootToken();
	 /*
	  * 我们已经创建了流程实例，当前流程实例应该是处于流程的开始节点
	  */
	 System.out.println("1当前流程节点："+token.getNode().getName());
	 //流程向下流转
	 token.signal();
	 /*
	  * 此时流程应该是第一个State节点上
	  * 我们的流程节点
	  */
	 System.out.println("2当前流程节点："+token.getNode().getName());
	 //流程向下流转
	 token.signal();
	 /*
	  * 此时流程处于什么位置呢？
	  * Node是一个自动执行的节点
	  * 我们打印流程节点名
	  * 此时应该打印的是第二个state节点
	  */
	 System.out.println("3当前流程节点："+token.getNode().getName());
	 //流程向下流转
	 token.signal();
	 /*
	  *此时应该到了流程的结束节点 
	  */
	 System.out.println("4当前流程节点："+token.getNode().getName());
	 //打印流程状态，看流程是否结束
	 System.out.println("5当前流程状态是否已经结束："+token.getProcessInstance().hasEnded());
	}

}

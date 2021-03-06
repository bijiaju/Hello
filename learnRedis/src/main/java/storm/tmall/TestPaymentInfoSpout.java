package storm.tmall;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import backtype.storm.utils.Utils;
import storm.tmall.other.PaymentInfo;

import java.util.Map;

public class TestPaymentInfoSpout extends BaseRichSpout {
    private SpoutOutputCollector collector;

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("paymentInfo"));
    }

    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
        this.collector = collector;
    }

    public void nextTuple() {
        collector.emit(new Values(new PaymentInfo().random()));
        Utils.sleep(10);
        /**
         * 继去年创下当天1261万笔支付的世界纪录后，支付宝在今年光棍节再度刷新这一纪录，创下当天支付成功3369万笔，
         * 比去年纪录增长了近170%！其中无线支付达到171万笔！11日0:01分，支付宝在一分钟内的付款笔数瞬间超过5.5万笔，
         * 是去年峰值的2.5倍。
         * 衷心感谢所有消费者、商家与银行与我们共同完成这一奇迹！
         * http://weibo.com/1627897870/xx1sduqnC?type=comment
         */
    }
}

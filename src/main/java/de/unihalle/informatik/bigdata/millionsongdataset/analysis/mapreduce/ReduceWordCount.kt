package de.unihalle.informatik.bigdata.millionsongdataset.analysis.mapreduce

import org.apache.hadoop.io.IntWritable
import org.apache.hadoop.io.Text
import org.apache.hadoop.mapreduce.Reducer

class ReduceWordCount : Reducer<Text, IntWritable, Text, IntWritable>() {
    public override fun reduce(
            key: Text,
            values: Iterable<IntWritable>,
            context: Reducer<Text, IntWritable, Text, IntWritable>.Context) {
        var sum = 0
        for (value in values) {
            sum += value.get()
        }
        context.write(key, IntWritable(sum))
    }
}
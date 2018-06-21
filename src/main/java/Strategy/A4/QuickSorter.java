package strategy.a4;

public class QuickSorter implements Sorter {
    Comparable[] data;

    @Override
    public void sort(final Comparable[] data) {
        this.data = data;
        qsort(0, data.length - 1);
    }

    private void qsort(int pre, int post) {
        final int saved_pre = pre;
        final int saved_post = post;
        final Comparable mid = data[(pre + post) / 2];
        do {
            while (data[pre].compareTo(mid) < 0) {
                pre++;
            }
            while (mid.compareTo(data[post]) < 0) {
                post--;
            }
            if (pre <= post) {
                final Comparable tmp = data[pre];
                data[pre] = data[post];
                data[post] = tmp;
                pre++;
                post--;
            }
        } while (pre <= post);
        if (saved_pre < post) {
            qsort(saved_pre, post);
        }
        if (pre < saved_post) {
            qsort(pre, saved_post);
        }
    }
}
